import React, { Component } from 'react';
import "./App.scss"
import { Route, Routes } from 'react-router-dom';
import {Login,Signup} from './components';
import Home from './containers/Home';


class App extends Component {
  render() {
    return (
      <Routes>
        <Route path='login' element={<Login />} />
        <Route path='signup' element={<Signup />} />
        <Route path='*' element={<Home />} />
      </Routes>
    );
  }
}

export default App;
