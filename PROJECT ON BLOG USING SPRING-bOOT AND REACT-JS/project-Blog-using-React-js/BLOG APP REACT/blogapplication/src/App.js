
import './App.css';
import 'bootstrap/dist/css/bootstrap.min.css';

import Base from './components/Base';
import About from './pages/About';
import { BrowserRouter, Routes, Route } from 'react-router-dom'
import Login from './pages/Login';
import Signup from './pages/Signup';
import Home from './pages/Home';

function App() {
  return (

    <BrowserRouter>
      <Routes>

        <Route path='home' element="<h1>this is home</h1> " />
        <Route path='home2' element={<h1>this is second home page</h1>} />
        <Route path='/' element={<Home />} />
        <Route path='login' element={<Login />} />
        <Route path='signup' element={<Signup />} />
        <Route path='/about' element={<About />} />
      </Routes>
    </BrowserRouter>


  );
}

export default App;
