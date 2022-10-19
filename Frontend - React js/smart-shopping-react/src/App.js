import logo from './logo.svg';
import './App.css';
import UserAdd from './Webpages/userAdd';
import ProductAdd from './Webpages/productAdd';
import ListProduct from './Webpages/listProduct';
import ListUsers from './Webpages/listUsers';
import {Switch,Routes, Route, Redirect, Router, BrowserRouter } from "react-router-dom";

function App() {
  return (
    <BrowserRouter>
    <div>
    <Routes>
    <Route path="/" element={<UserAdd/>} />
    <Route path="/product" element={<ProductAdd/>} />
    <Route path="/productlist" element={<ListProduct/>} />
    <Route path="/userlist" element={<ListUsers/>} />
    </Routes>
    </div>
    </BrowserRouter>
  );
}

export default App;
