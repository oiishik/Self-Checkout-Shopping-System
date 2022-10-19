import React, { Component } from 'react'
import Navbar from '../Components/navbar'
import ProductList from '../Components/productList'

export default class ListProduct extends Component {
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
        <ProductList/>
      </>
    )
  }
}
