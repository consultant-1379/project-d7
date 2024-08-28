/**
 * Component NumberCommitsComponent is defined as
 * `<e-number-commits-component>`
 *
 * Imperatively create component
 * @example
 * let component = new NumberCommitsComponent();
 *
 * Declaratively create component
 * @example
 * <e-number-commits-component></e-number-commits-component>
 *
 * @extends {LitComponent}
 */
import { LitComponent, html, definition } from '@eui/lit-component';
import { Button } from '@eui/base'
import { Table } from '@eui/table';
import style from './number-commits-component.css';

export default class NumberCommitsComponent extends LitComponent {
  // Uncomment this block to add initialization code
  // constructor() {
  //   super();
  //   // initialize
  // }
  _fetchData() {
    fetch('http://localhost:9090/date')
    // fetch('http://spring-boot:9090/date')
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
      { title: 'Date', attribute: 'date' },
      { title: 'Commits', attribute: 'commits' }
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
definition('e-number-commits-component', {
  style,
  props: {
    dataObject: { attribute: true, type: Object },
  },
})(NumberCommitsComponent);
