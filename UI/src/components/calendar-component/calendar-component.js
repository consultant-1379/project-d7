/**
 * Component CalendarComponent is defined as
 * `<e-calendar-component>`
 *
 * Imperatively create component
 * @example
 * let component = new CalendarComponent();
 *
 * Declaratively create component
 * @example
 * <e-calendar-component></e-calendar-component>
 *
 * @extends {LitComponent}
 */
import { LitComponent, html, definition } from '@eui/lit-component';
import { Datepicker } from '@eui/base';
import style from './calendar-component.css';

export default class CalendarComponent extends LitComponent {
  // Uncomment this block to add initialization code
  // constructor() {
  //   super();
  //   // initialize
  // }

  static get components() {
    return {
      'eui-datepicker': Datepicker,
    };
  }

  /**
   * Render the <e-calendar-component> component. This function is called each time a
   * prop changes.
   */
  render() {
    return html`

      <eui-datepicker class="datepicker" min="${this.minDate}" max="${this.maxDate}"></eui-datepicker>

    `;
  }
}

/**
 * @property {Boolean} propOne - show active/inactive state.
 * @property {String} propTwo - shows the "Hello World" string.
 */
definition('e-calendar-component', {
  style,
  props: {
    minDate: {attribute: true, type: String, default: ""},
    maxDate: {attribute: true, type: String, default: ""},
  },
})(CalendarComponent);
