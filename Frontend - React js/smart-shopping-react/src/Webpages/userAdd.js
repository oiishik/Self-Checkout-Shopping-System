import PropTypes from 'prop-types'
import React, { Component } from 'react'
import Navbar from '../Components/navbar'
import AddUser from '../Components/addUser'
import {Switch,Routes, Route, Redirect, Router, BrowserRouter } from "react-router-dom";
export default class UserAdd extends Component {
    constructor(props) {
        super(props)
        this.state = {
        }
    }

  render() {
    return (
      <>
      <Navbar/>
      <AddUser/>
      </>
    )
  }
}
