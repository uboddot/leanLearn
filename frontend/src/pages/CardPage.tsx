import { useEffect, useState } from "react";
import { getWords, getKastenLevels } from "../services/cardService";
import type { Voci } from "../types/Voci";
import { VociCard } from "../components/VociCard";
import { Stack } from "../components/Stack";
import Kasten from "../components/Kasten";
import KastenLaatikko from "../components/KastenLaatikko";
import './CardPageStyle.css';

export default function CardPage() {

  const [words, setWords] = useState<Voci[]>([]);
  const [errorVoci, setErrorVoci] = useState<string | null>(null);
  const [loadingVoci, setLoadingVoci] = useState<boolean>(true);
  
  const [kastenLevels, setKastenLevels] = useState<number[]>([]);
  const [errorKastenLevels, setErrorKastenLevels] = useState<string | null>(null);
  const [loadingKastenLevels, setLoadingKastenLevels] = useState<boolean>(true);

  useEffect(() => {
    async function fetchWords() {
      try {
        setLoadingVoci(true);
        setErrorVoci(null);
        const response = await getWords();
        setWords(response);
      } catch {
        setErrorVoci("Failed to fetch words");
      } finally {
        setLoadingVoci(false);
      }
    }
    fetchWords();
  }, []);

  useEffect(() => {
    async function fetchKastenLevels() {
      try {
        setLoadingKastenLevels(true);
        setErrorKastenLevels(null);
        const response = await getKastenLevels();
        setKastenLevels(response);
      } catch {
        setErrorKastenLevels("Failed to fetch kasten levels");
      } finally {
        setLoadingKastenLevels(false);
      }
    }
    fetchKastenLevels();
  }, []);
  
  return (
    <div className="card-page">
      <Kasten>
        {loadingKastenLevels ? 'Loading...' : errorKastenLevels ? errorKastenLevels : kastenLevels.map((level, index) => (
          <KastenLaatikko title={`${level}`} subtitle={`${words.filter(voci => voci.vociKastenLevel === level).length}`} key={`${index}`}>      
              <Stack>
                {loadingVoci ? 'Loading...' : errorVoci ? errorVoci : words.filter(voci => voci.vociKastenLevel === level).map((voci, index) => (
                  <VociCard key={`${index}`} item={voci} />
                ))}
              </Stack>
          </KastenLaatikko>
        ))}
      </Kasten>
    </div>
  )
}