/**
 * Component TestComponent is defined as
 * `<e-test-component>`
 *
 * Imperatively create component
 * @example
 * let component = new TestComponent();
 *
 * Declaratively create component
 * @example
 * <e-test-component></e-test-component>
 *
 * @extends {LitComponent}
 */
import { LitComponent, html, definition } from '@eui/lit-component';
import { Accordion, Button } from '@eui/base'
import { Table } from '@eui/table';
import style from './test-component.css';

export default class TestComponent extends LitComponent {
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
        this.contributorsArray = json
        console.log('parsed json ', json)
      }.bind(this)).catch(function (ex) {
        console.log('parsing failed', ex)
      })
  }

  _updateTable(dataArray) {
    // find the table Element in the DOM...
    const tableElement = this.shadowRoot.getElementById("table1");
    console.log(tableElement);
    // this is the row to add
    for (const item of dataArray) {
      const rowToAdd = item;
      tableElement.data = [...tableElement.data, rowToAdd];

    }
  }


  static get components() {
    return {
      // register components here
      'eui-button': Button,
      'eui-table': Table,
      'eui-accordion': Accordion,
    };
  }

  /**
   * Render the <e-test-component> component. This function is called each time a
   * prop changes.
   */
  render() {


    return html`
    <eui-button @click=${()=> this._fetchData()}>
      Fetch Data
    </eui-button>
    <eui-button @click=${()=> this._updateTable(this.contributorsArray)}>
      Update Table
    </eui-button>
    
    <eui-accordion category-title="Table 1" line>
      <eui-table id="table1" single-select sortable .columns=${columns} .data=${data}></eui-table>
    </eui-accordion>
    <eui-accordion category-title="Table 2" line>
      <eui-table id="table1" single-select sortable .columns=${columns} .data=${data}></eui-table>
    </eui-accordion>

    
    `;
  }
}



/**
 * @property {Boolean} propOne - show active/inactive state.
 * @property {String} propTwo - shows the "Hello World" string.
 */
definition('e-test-component', {
  style,
  props: {
    contributorsArray: { attribute: true, type: String },
  },
})(TestComponent);
