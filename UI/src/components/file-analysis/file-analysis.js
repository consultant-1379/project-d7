/**
 * Component FileAnalysis is defined as
 * `<e-file-analysis>`
 *
 * Imperatively create component
 * @example
 * let component = new FileAnalysis();
 *
 * Declaratively create component
 * @example
 * <e-file-analysis></e-file-analysis>
 *
 * @extends {LitComponent}
 */
import { LitComponent, html, definition } from '@eui/lit-component';
import { Button } from '@eui/base'
import { Table } from '@eui/table';
import style from './file-analysis.css';

export default class FileAnalysis extends LitComponent {
  // Uncomment this block to add initialization code
  // constructor() {
  //   super();
  //   // initialize
  // }

  _fetchData() {
    fetch('http://localhost:9090/fa')
    // fetch('http://spring-boot:9090/fa')
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

  render() {
    const columns = [
      { title: 'File Name', attribute: 'file' },
      { title: 'Contributors Count', attribute: 'contributors' },
      { title: 'Minor Contributors Count', attribute: 'minorContributors'},
      { title: 'Lines Added', attribute: 'linesAdded'},
      { title: 'Lines Removed', attribute: 'linesRemoved'},
      { title: 'Max Code Churn', attribute: 'maxCodeChurn'},
      { title: 'Average Code Churn', attribute: 'avgCodeChurn'},
      { title: 'Highest Contributor % of Lines', attribute: 'highestContributor'},
      { title: 'Hunks Count', attribute: 'hunksCount'}

    ];


    return html`
    <eui-button @click=${() => this._fetchData()}>
      Fetch Data
    </eui-button>
    <eui-button @click=${() => this._updateTable(this.dataObject)}>
      Update Table
    </eui-button>
    
    <eui-table id="table1" single-select sortable resizable .columns=${columns}></eui-table>
    
    
    `;
  }
}

/**
 * @property {Object} dataObject - Object with data from REST
 */
definition('e-file-analysis', {
  style,
  props: {
    dataObject: { attribute: true, type: Object },
  },
})(FileAnalysis);
