import { createContext } from "react";
import type { Voci } from "../types/Voci";

export const VociCardContext = createContext<{voci: Voci}>({voci: {id: "",original: "", originalLanguage: "", translation: "", translationLanguage: "", vociKastenLevel: 0}});