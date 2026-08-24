import { useReducer } from "react";
import type { Voci } from "../types/Voci";
import { VociCardSide } from "./VociCardSide";
import "./VociCardStyle.css";
import { VociCardContext } from "./VociCardContext";

export function VociCard({item: voci }: {item: Voci}) {

    const [showingOriginal, toggleShowingOriginal] = useReducer((state: boolean) => !state, true);
    
    return (
        <VociCardContext value={{voci: voci}}>            
            <div className="vociCard"
            onClick={(e) => { e.stopPropagation(); toggleShowingOriginal(); }}
            >
                {showingOriginal ? (
                    <>
                        <VociCardSide props={{word: voci.original, language: voci.originalLanguage}} />
                    </>
                ) : (
                    <>
                        <VociCardSide props={{word: voci.translation, language: voci.translationLanguage, flipped: true}} />
                    </>
                )}
            </div>
        </VociCardContext>
    )
}