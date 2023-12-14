import { useState } from 'react';
import './App.css';
import Sidebar from './components/Sidebar';
import History from './components/History';
import AddTransaction from './components/AddTransaction';

function App() {

  const [addButton, setAddButton] = useState(false);
  const [historyButton, setHistoryButton] = useState(true);
  return (
    <div>
      <Sidebar setAddButton={setAddButton} setHistoryButton={setHistoryButton} />
      {
        addButton && (
          <AddTransaction />
        )
      }
      {
        historyButton && (
          <History />
        )
      }
    </div>
  );
}

export default App;
