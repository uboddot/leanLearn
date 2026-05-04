import { useEffect, useState } from "react";
import { getWords } from "../services/cardService";
import type { Voci } from "../types/Voci";

export default function CardPage() {

  const [words, setWords] = useState<Voci[]>([]);

  useEffect(() => {
    async function fetchWords() {
      const response = await getWords();
      setWords(response);
    }
    fetchWords();
  }, []);
  
  return (
      <div style={{ textAlign: 'center', fontSize: '24px', fontWeight: 'bold' }}>
        {words ? words.map((item, index) => (
          <div key={index}>{item.original} - {item.translation}</div>
        )) : 'Loading...'}
      </div>
  )
}