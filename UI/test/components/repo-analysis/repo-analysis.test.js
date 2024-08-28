import { expect, fixture } from '@open-wc/testing';
import RepoAnalysis from '../../../src/components/repo-analysis/repo-analysis.js';

describe('RepoAnalysis Component Tests', () => {
  before(() => {
    RepoAnalysis.register();
  });

  describe('Basic component setup', () => {
    it('should render <e-repo-analysis>', async () => {
      const component = await fixture(
        '<e-repo-analysis></e-repo-analysis>',
      );
      const headingTag = component.shadowRoot.querySelector('h1');

      expect(
        headingTag.textContent,
        '"Your component markup goes here" was not found',
      ).to.equal('Your component markup goes here');
    });
  });
});
