import { useReducer } from "react";
import './KastenLaatikkoStyle.css';

export default function KastenLaatikko({ children, title, subtitle }: { children: React.ReactNode; title: string; subtitle: string }) {
    
    const [isOpen, toggleOpen] = useReducer((isOpen: boolean) => !isOpen, false);

    return (
    <div className="kasten-laatikko">
      <button onClick={toggleOpen}>        
        <div style={{ display: "flex", flexDirection: "row", alignItems: "center", justifyContent: "space-around" }}>
            <h2>{title}</h2>
            <h3>📇 {subtitle}</h3>
        </div>
        {isOpen && children}
      </button>
    </div>
  );
}

