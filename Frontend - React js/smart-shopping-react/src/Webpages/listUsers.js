import React, { Component } from 'react'
import Navbar from '../Components/navbar'
import UserList from '../Components/userlist'

export default class ListUsers extends Component {
    constructor(props) {
        super(props)
        this.state = {
            products: [],
        }
    }
  render() {
    return (
      <>
        <Navbar/>
        <UserList/>
      </>
    )
  }
}
