import React from 'react';
import './App.css';
import Sensors from './components/sensors/Sensors';
import Header from './components/header/Header';

function App() {
  return (
    <div className='App'>
      <Header />
      <br/>
      <Sensors />
    </div>
  );
}

export default App;
