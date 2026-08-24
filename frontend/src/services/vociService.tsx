export async function bumpVoci(vociId: string): Promise<void> {
    return fetch(`/api/voci/bump/${vociId}`, {
        method: "PUT",
    }).then((response) => {
        if (!response.ok) {
            throw new Error(`Request failed: ${response.status} ${response.statusText}`);
        }
    });
}