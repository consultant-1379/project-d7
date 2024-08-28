/**
 * Component UserInput is defined as
 * `<e-user-input>`
 *
 * Imperatively create component
 * @example
 * let component = new UserInput();
 *
 * Declaratively create component
 * @example
 * <e-user-input></e-user-input>
 *
 * @extends {LitComponent}
 */
import { LitComponent, html, definition } from '@eui/lit-component';
import style from './user-input.css';

export default class UserInput extends LitComponent {
  // Uncomment this block to add initialization code
  // constructor() {
  //   super();
    

  // }

  static get components() {
    return {
      
    };
  }

  /**
   * Render the <e-user-input> component. This function is called each time a
   * prop changes.
   */
  render() {
    return html`

      <input type="text" id="repo-name" name="repo-name">

    `;
  }
}

/**
 * @property {Boolean} propOne - show active/inactive state.
 * @property {String} propTwo - shows the "Hello World" string.
 */
definition('e-user-input', {
  style,
  props: {
  },
})(UserInput);
