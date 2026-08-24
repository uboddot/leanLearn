import { useContext } from "react";
import { VociCardContext } from "./VociCardContext";
import { bumpVoci } from "../services/vociService";

export function FlippedCardButtons() {

    const vociCardContext = useContext(VociCardContext);

    return (
        <div style={{ display: 'flex', justifyContent: 'center', gap: '10px', marginTop: '10px' }}>
            <button onClick={(e) => {e.stopPropagation(); bumpVoci(vociCardContext.voci.id); console.log("Bumped voci:", vociCardContext.voci.id); }}>ok</button>
            <button>nok</button>
        </div>
    );
}