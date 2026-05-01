import { useEffect } from "react";
import { getWords } from "../services/cardService";

export default function CardPage() {

  useEffect(() => {
    getWords();
  }, []);

  return (
      <div style={{ textAlign: 'center', fontSize: '24px', fontWeight: 'bold' }}>
        Heloooo Anja, bruu
      </div>
  )
}