import { expect, fixture } from '@open-wc/testing';
import NumberCommitsComponent from '../../../src/components/number-commits-component/number-commits-component.js';

describe('NumberCommitsComponent Component Tests', () => {
  before(() => {
    NumberCommitsComponent.register();
  });

  describe('Basic component setup', () => {
    it('should render <e-number-commits-component>', async () => {
      const component = await fixture(
        '<e-number-commits-component></e-number-commits-component>',
      );
      const headingTag = component.shadowRoot.querySelector('h1');

      expect(
        headingTag.textContent,
        '"Your component markup goes here" was not found',
      ).to.equal('Your component markup goes here');
    });
  });
});
