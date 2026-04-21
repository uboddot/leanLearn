import { test, expect } from '@playwright/test';

test('lean learn home page is present', async({ page }) => {
  await page.goto('/');

  await expect(page).toHaveTitle(/frontend/);
});