import React, { Component } from 'react'
import Navbar from '../Components/navbar'
import AddProduct from '../Components/addProduct'

export default class ProductAdd extends Component {
    constructor(props) {
        super(props)
        this.state = {
        }
    }
  render() {
    return (
      <>
        <Navbar/>
        <AddProduct/>
      </>
    )
  }
}
