import { FlippedCardButtons } from "./FlippedCardButtons";

export function VociCardSide({props: {word , language, flipped}}: {props: {word: string, language: string, flipped?: boolean}}) {
    return (
        <div style={{ textAlign: 'center', fontSize: '24px', fontWeight: 'bold' }}>
            <div>
                {word} ({language})
            </div>
            <div>
                {flipped && <FlippedCardButtons />}
            </div>
        </div>
    )
}