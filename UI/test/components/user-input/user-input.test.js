import { expect, fixture } from '@open-wc/testing';
import UserInput from '../../../src/components/user-input/user-input.js';

describe('UserInput Component Tests', () => {
  before(() => {
    UserInput.register();
  });

  describe('Basic component setup', () => {
    it('should render <e-user-input>', async () => {
      const component = await fixture(
        '<e-user-input></e-user-input>',
      );
      const headingTag = component.shadowRoot.querySelector('h1');

      expect(
        headingTag.textContent,
        '"Your component markup goes here" was not found',
      ).to.equal('Your component markup goes here');
    });
  });
});
