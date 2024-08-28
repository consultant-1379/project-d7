/**
 * Component RepoAnalysis is defined as
 * `<e-repo-analysis>`
 *
 * Imperatively create component
 * @example
 * let component = new RepoAnalysis();
 *
 * Declaratively create component
 * @example
 * <e-repo-analysis></e-repo-analysis>
 *
 * @extends {LitComponent}
 */
import { LitComponent, html, definition } from '@eui/lit-component';
import { Button } from '@eui/base'
import { Table } from '@eui/table';
import style from './repo-analysis.css';

export default class RepoAnalysis extends LitComponent {
  // Uncomment this block to add initialization code
  // constructor() {
  //   super();
  //   // initialize
  // }

  _fetchData() {
    fetch('http://localhost:9090/ga')
    // fetch('http://spring-boot:9090/ga')
      .then(function (response) {
        return response.json()
      }).then(function (json) {
        this.dataObject = json
        console.log('parsed json ', json)
      }.bind(this)).catch(function (ex) {
        console.log('parsing failed', ex)
      })
  }

  _updateTable(dataArray) {
    // find the table Element in the DOM...
    const tableElement = this.shadowRoot.getElementById("table1");
    // Adds rows from array
    for (const item of dataArray) {
      const rowToAdd = item;
      tableElement.data = [...tableElement.data, rowToAdd];

    }
  }

  static get components() {
    return {
      'eui-button': Button,
      'eui-table': Table,
    };
  }

  /**
   * Render the <e-contributions-per-contributor> component. This function is called each time a
   * prop changes.
   */
  render() {
    const columns = [
      { title: 'Lines Added', attribute: 'linesAdded'},
      { title: 'Lines Removed', attribute: 'linesRemoved'},
      { title: 'Max Change set', attribute: 'maxChangeSet'},
      { title: 'Average Change set', attribute: 'avgChangeSet'},
      { title: 'Total commits', attribute: 'totalCommits'}
    ];


    return html`
    <eui-button @click=${() => this._fetchData()}>
      Fetch Data
    </eui-button>
    <eui-button @click=${() => this._updateTable(this.dataObject)}>
      Update Table
    </eui-button>
    
    <eui-table id="table1" single-select sortable .columns=${columns}></eui-table>
    
    
    `;
  }
}

/**
 * @property {Object} dataObject - Object with data from REST
 */
definition('e-repo-analysis', {
  style,
  props: {
    dataObject: { attribute: true, type: Object },
  },
})(RepoAnalysis);
