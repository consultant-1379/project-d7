/**
 * Component ContribsComponent is defined as
 * `<e-contribs-component>`
 *
 * Imperatively create component
 * @example
 * let component = new ContribsComponent();
 *
 * Declaratively create component
 * @example
 * <e-contribs-component></e-contribs-component>
 *
 * @extends {LitComponent}
 */
import { LitComponent, html, definition } from '@eui/lit-component';
import { Button } from '@eui/base'
import { Table } from '@eui/table';
import style from './contribs-component.css';

export default class ContribsComponent extends LitComponent {
  // Uncomment this block to add initialization code
  // constructor() {
  //   super();
  //   // initialize
  // }

  _fetchData() {
    fetch('http://localhost:9090/contrib')
    // fetch('http://spring-boot:9090/contrib')
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
      { title: 'Contributions', attribute: 'contributions' },
      { title: 'Name', attribute: 'userName' }
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
definition('e-contribs-component', {
  style,
  props: {
    dataObject: { attribute: true, type: Object },
  },
})(ContribsComponent);
