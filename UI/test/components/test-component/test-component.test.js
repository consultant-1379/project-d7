import { expect, fixture } from '@open-wc/testing';
import TestComponent from '../../../src/components/test-component/test-component.js';

describe('TestComponent Component Tests', () => {
  before(() => {
    TestComponent.register();
  });

  describe('Basic component setup', () => {
    it('should render <e-test-component>', async () => {
      const component = await fixture(
        '<e-test-component></e-test-component>',
      );
      const headingTag = component.shadowRoot.querySelector('h1');

      expect(
        headingTag.textContent,
        '"Your component markup goes here" was not found',
      ).to.equal('Your component markup goes here');
    });
  });
});
