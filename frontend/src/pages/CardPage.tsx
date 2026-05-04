import { useEffect, useState } from "react";
import { getWords } from "../services/cardService";
import type { Voci } from "../types/Voci";

export default function CardPage() {

  const [words, setWords] = useState<Voci[]>([]);
  const [error, setError] = useState<string | null>(null);
  const [loading, setLoading] = useState<boolean>(true);

  useEffect(() => {
    async function fetchWords() {
      try {
        setLoading(true);
        setError(null);
        const response = await getWords();
        setWords(response);
      } catch {
        setError("Failed to fetch words");
      } finally {
        setLoading(false);
      }
    }
    fetchWords();
  }, []);
  
  return (
    <div style={{ textAlign: 'center', fontSize: '24px', fontWeight: 'bold' }}>
      {loading ? 'Loading...' : error ? error : words.map((item, index) => (
        <div key={index}>{item.original} - {item.translation}</div>
      ))}
    </div>
  )
}