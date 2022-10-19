import PropTypes from 'prop-types'
import React, { Component } from 'react'
import {Typography, AppBar, Card, CardActions, CardContent, CardMedia, CssBaseline, Grid, Link,Toolbar,Container,ButtonGroup,Button} from '@mui/material'
import AddShoppingCartIcon from '@mui/icons-material/AddShoppingCart';
import {Switch,Routes, Route, Redirect, Router, BrowserRouter, NavLink } from "react-router-dom";
export default class navbar extends Component {
 

  render() {
    return (
        <>
        <CssBaseline />
         <AppBar position="relative">
          <Toolbar>
            <AddShoppingCartIcon />
            <Typography variant="h6" color="inherit" noWrap style={{padding:'0px 5px'}}>ShopEasy: Admin Panel
            </Typography>
          </Toolbar>
        </AppBar> 
        <main style={{marginTop:'10px', padding:'0px 10px'}}>
        <NavLink to="/" style={{ textDecoration: "none" }}>
          <Link href="/" underline="hover" style={{padding:'0px 5px'}}>
             Add User
          </Link>
        </NavLink>
        <NavLink to="/product" style={{ textDecoration: "none" }}>
          <Link href="/product" underline="hover" style={{padding:'0px 5px'}}>
              Add Product
          </Link>
        </NavLink>
        <NavLink to="/userlist" style={{ textDecoration: "none" }}>
          <Link href="#" underline="hover" style={{padding:'0px 5px'}}>
              User List
          </Link>
        </NavLink>
        <NavLink to="/productlist" style={{ textDecoration: "none" }}>
          <Link href="#" underline="hover" style={{padding:'0px 5px'}}>
              Product List
          </Link>
        </NavLink>
        </main>
        </>
    )
  }
}
