import { useReducer } from "react";
import type { Voci } from "../types/Voci";
import { VociCardSide } from "./VociCardSide";
import "./VociCardStyle.css";

export function VociCard({item: voci }: {item: Voci}) {

    const [showingOriginal, toggleShowingOriginal] = useReducer((state: boolean) => !state, true);

    return (
        <div className="vociCard"
        onClick={() => toggleShowingOriginal()}>
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
    )
}