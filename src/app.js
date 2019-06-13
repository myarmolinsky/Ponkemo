import React from 'react';
import './App.css';
import Search from './Search'

function App() {
    return (
        <div className="App">
            <header className="App-header">
                <p>Pokemon will appear below when you press the "Search" button:</p><Search />
            </header>
        </div>
    );
}

export default App;