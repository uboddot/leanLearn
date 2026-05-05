export type { Voci };
export { isVociArray };

type Voci = {
    original: string;
    translation: string;
}

function isVociArray(data: unknown): data is Voci[] {
  return Array.isArray(data) && data.every(item =>
    typeof item === "object" && 
    item !== null &&
    typeof (item as {original?: unknown}).original === 'string' && 
    typeof (item as {translation?: unknown}).translation === 'string'
  );
}