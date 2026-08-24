import { useContext } from "react";
import { VociCardContext } from "./VociCardContext";

export function FlippedCardButtons() {

    const vociCardContext = useContext(VociCardContext);

    console.log("FlippedCardButtons vociCardContext:", vociCardContext.voci.id);

    return (
        <div style={{ display: 'flex', justifyContent: 'center', gap: '10px', marginTop: '10px' }}>
            <button>ok</button>
            <button>nok</button>
        </div>
    );
}