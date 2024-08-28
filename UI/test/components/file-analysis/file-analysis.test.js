import { expect, fixture } from '@open-wc/testing';
import FileAnalysis from '../../../src/components/file-analysis/file-analysis.js';

describe('FileAnalysis Component Tests', () => {
  before(() => {
    FileAnalysis.register();
  });

  describe('Basic component setup', () => {
    it('should render <e-file-analysis>', async () => {
      const component = await fixture(
        '<e-file-analysis></e-file-analysis>',
      );
      const headingTag = component.shadowRoot.querySelector('h1');

      expect(
        headingTag.textContent,
        '"Your component markup goes here" was not found',
      ).to.equal('Your component markup goes here');
    });
  });
});
