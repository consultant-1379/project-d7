/**
 * Integration tests for <e-main-app>
 */
import { expect, fixture } from '@open-wc/testing';
import '../../../src/apps/main-app/main-app.js';

describe('MainApp Application Tests', () => {
  describe('Basic application setup', () => {
    it('should create a new <e-main-app>', async () => {
      const element = await fixture('<e-main-app></e-main-app>');
      const headingTag = element.shadowRoot.querySelector('h1');

      expect(
        headingTag.textContent,
        '"Your app markup goes here" was not found',
      ).to.equal('Your app markup goes here');
    });
  });
});
