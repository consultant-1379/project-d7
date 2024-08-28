import { expect, fixture } from '@open-wc/testing';
import CalendarComponent from '../../../src/components/calendar-component/calendar-component.js';

describe('CalendarComponent Component Tests', () => {
  before(() => {
    CalendarComponent.register();
  });

  describe('Basic component setup', () => {
    it('should render <e-calendar-component>', async () => {
      const component = await fixture(
        '<e-calendar-component></e-calendar-component>',
      );
      const headingTag = component.shadowRoot.querySelector('h1');

      expect(
        headingTag.textContent,
        '"Your component markup goes here" was not found',
      ).to.equal('Your component markup goes here');
    });
  });
});
