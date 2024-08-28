/**
 * MainApp is defined as
 * `<e-main-app>`
 *
 * Imperatively create application
 * @example
 * let app = new MainApp();
 *
 * Declaratively create application
 * @example
 * <e-main-app></e-main-app>
 *
 * @extends {App}
 */
import { App, html, definition } from '@eui/app';
import style from './main-app.css';
import { Button, Accordion } from '@eui/base'
import ContribsComponent from '../../components/contribs-component/contribs-component';
import NumberCommitsComponent from '../../components/number-commits-component/number-commits-component';
import FileAnalysis from '../../components/file-analysis/file-analysis';
import RepoAnalysis from '../../components/repo-analysis/repo-analysis';
import CalendarComponent from '../../components/calendar-component/calendar-component';
import TextField from '../../components/user-input/user-input';

export default class MainApp extends App {
  
  // constructor() {
  //   super();
    
  // }

  static get components() {
    return {
      // register components here
      'eui-button': Button,
      'e-contribs-component': ContribsComponent,
      'eui-accordion': Accordion,
      'e-contributions-per-contributor': NumberCommitsComponent,
      'e-file-analysis':FileAnalysis,
      'e-repo-analysis':RepoAnalysis,
      'eui-calendar-component': CalendarComponent,
      'eui-user-input': TextField,
    };
  }

  async _submitRepoName() {
    let repo_input = this.shadowRoot.getElementById("repo-input");
    let repo_value = repo_input.shadowRoot.getElementById("repo-name").value;

    let calendarsDiv = this.shadowRoot.getElementById("datesSelectDIV");
    calendarsDiv.style.display = "block";

    let repoInputDiv = this.shadowRoot.getElementById("repoInputDIV");
    repoInputDiv.style.display = "none";

    await this._fetchActivityDates();
    await this._setCalendarDates();
  }

  async _setCalendarDates() {
    let firstDatepickerCmp = this.shadowRoot.getElementById("first-date");
    let secondDatepickerCmp = this.shadowRoot.getElementById("second-date");

    let firstDatepicker = firstDatepickerCmp.shadowRoot.children[1];
    let secondDatepicker = secondDatepickerCmp.shadowRoot.children[1];

    firstDatepicker.setAttribute("min", this.activityDates[0].date);
    firstDatepicker.setAttribute("max", this.activityDates[this.activityDates.length - 1].date);

    secondDatepicker.setAttribute("min", this.activityDates[0].date);
    secondDatepicker.setAttribute("max", this.activityDates[this.activityDates.length - 1].date);
  }

  async _fetchActivityDates() {
    await fetch('http://localhost:9090/repoActivity')
      .then(function (response) {
        return response.json()
      }).then(function (json) {
        this.activityDates = json
        console.log('parsed json ', json)
      }.bind(this)).catch(function (ex) {
        console.log('parsing failed', ex)
      })
  }

  _submitDates() {
    this.repoReceived = true;
  }

  didConnect() {
    this.bubble('app:title', { displayName: 'Git Miner' });
    this.bubble('app:subtitle', { subtitle: '' });
  }

  /**
   * Render the <e-main-app> app. This function is called each time a
   * prop changes.
   */
  render() {

    if(this.repoReceived) {
      return html`

        <eui-accordion category-title="Number of Contributions per contributor" line>
          <e-contribs-component></e-contribs-component>
        </eui-accordion>

        <eui-accordion category-title="Number of commits and when" line>
          <e-contributions-per-contributor></e-contributions-per-contributor>
        </eui-accordion>

        <eui-accordion category-title="Analysis per File" line>
          <e-file-analysis></e-file-analysis>
        </eui-accordion>

        <eui-accordion category-title="Analysis for Repo" line>
          <e-repo-analysis></e-repo-analysis>
        </eui-accordion>

      `;
    }

    else {
        return html`

          <div id="repoInputDIV">
          <p>Repository URL:</p>
          <eui-user-input id="repo-input"></eui-user-input>
          <eui-button @click="${ () => this._submitRepoName()}">Submit</eui-button>
          </div>

          <div id="datesSelectDIV">
          <p>Select dates for the repository analysis. No dates selected = Full scan</p>
          <eui-calendar-component id="first-date"></eui-calendar-component>
          <eui-calendar-component id="second-date"></eui-calendar-component>
          <eui-button id="submitDatesButton" @click="${ () => this._submitDates()}">Submit</eui-button>
          </div>
          
        `;
    }

  }
}

definition('e-main-app', {
  style,
  props: {
    repoReceived: {type: Boolean, default: false},
    activityDates: {attribute: true, type: Object},
  },
})(MainApp);

MainApp.register();
