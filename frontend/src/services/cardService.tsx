import { isVociArray, type Voci } from "../types/Voci";
import type { KastenLevel } from "../types/KastenLevel";

export { getWords , getKastenLevels };

const getWords: () => Promise<Voci[]> = async () => {
  const response = await fetch("/api/voci");

  if (!response.ok) {
    throw new Error(`Request failed: ${response.status} ${response.statusText}`);
  }

  const contentType = response.headers.get("content-type") ?? "";
  if (!contentType.includes("application/json")) {
    const bodyPreview = (await response.text()).slice(0, 200);
    throw new Error(`Expected JSON but received: ${bodyPreview}`);
  }

  const data = await response.json();
  if(!isVociArray(data)) {
    const bodyPreview = JSON.stringify(data).slice(0, 200);
    throw new Error(`Response does not match expected format: ${bodyPreview}`);
  }
  return data;
}

const getKasten: () => Promise<KastenLevel[]> = async () => {
  const response = await fetch("/api/voci-kasten");

  if (!response.ok) {
    throw new Error(`Request failed: ${response.status} ${response.statusText}`);
  }

  const contentType = response.headers.get("content-type") ?? "";
  if (!contentType.includes("application/json")) {
    const bodyPreview = (await response.text()).slice(0, 200);
    throw new Error(`Expected JSON but received: ${bodyPreview}`);
  }

  return await response.json();
}

const getKastenLevels: () => Promise<number[]> = async () => {
  const kasten = await getKasten();
  return kasten.map(item => item.level);
}
