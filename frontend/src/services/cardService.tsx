export { getWords };

const getWords = async () => {
  const response = await fetch("/api/voci");

  if (!response.ok) {
    throw new Error(`Request failed: ${response.status} ${response.statusText}`);
  }

  const contentType = response.headers.get("content-type") ?? "";
  if (!contentType.includes("application/json")) {
    const bodyPreview = (await response.text()).slice(0, 200);
    throw new Error(`Expected JSON but received: ${bodyPreview}`);
  }

  const data = await response.json();
  console.log("Data from /api/voci:", data);
}