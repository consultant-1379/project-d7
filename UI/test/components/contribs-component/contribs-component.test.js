import { expect, fixture } from '@open-wc/testing';
import ContribsComponent from '../../../src/components/contribs-component/contribs-component.js';

describe('ContribsComponent Component Tests', () => {
  before(() => {
    ContribsComponent.register();
  });

  describe('Basic component setup', () => {
    it('should render <e-contribs-component>', async () => {
      const component = await fixture(
        '<e-contribs-component></e-contribs-component>',
      );
      const headingTag = component.shadowRoot.querySelector('h1');

      expect(
        headingTag.textContent,
        '"Your component markup goes here" was not found',
      ).to.equal('Your component markup goes here');
    });
  });
});
