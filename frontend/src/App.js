import React, { Component, useState } from 'react';
import "./App.scss"
import { Route, Routes, useNavigate } from 'react-router-dom';
import {Login,Signup} from './components';
import Home from './containers/Home';


const App = () => {

  const [token , setToken] = useState();

  

  return (
    <Routes>
      <Route path='login' element={<Login />} />
      <Route path='signup' element={<Signup />} />
      <Route path='home' element={<Home />} />
      <Route path='*' element={<Login />} />
    </Routes>
  );
}


export default App;
