import './StackStyle.css';

export function Stack({children}: {children: React.ReactNode}) {
    return (
        <div className="stack">
            {children}
        </div>
    )
}