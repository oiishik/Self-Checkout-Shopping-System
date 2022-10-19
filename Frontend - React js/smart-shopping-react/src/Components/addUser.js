import React, { Component } from 'react'
import {FormControl, InputLabel,FormHelperText,Input,Container,Grid,Typography,Button} from '@mui/material'
export default class AddUser extends Component {
    //CRATE A CONSTRUCTOR
    constructor(props) {
        super(props)
        this.state = {
            name: '',
            email: '',
            mobile: '',
            rfid_No: ''
        }
    }

    addUser = (e) => {
        console.log(this.state)
        e.preventDefault()
        fetch('http://localhost:8080/user/add', {
          method: 'POST',
          headers: {'Content-Type': 'application/json'},
          body: JSON.stringify(this.state)
        }).then(() => {
            alert('User Added Successfully')
            window.location.reload()
        })
    }

  render() {
    return (
      <>
        <Container maxWidth="sm" style={{marginTop:'50px'}}>  
        <Typography variant="h4" color="#34A5DD" noWrap style={{padding:'0px 5px', marginBottom: '10px'}}>Add User
        </Typography>  
        <form>
        <Grid container spacing={2}>
        <Grid item xs={12}  style={{marginTop:'10px'}}>
        <FormControl fullWidth>
        <InputLabel htmlFor="my-input">User Name</InputLabel >
        <Input id="my-input" aria-describedby="my-helper-text" onChange={(e)=>this.setState({name: e.target.value })}/>
        <FormHelperText id="my-helper-text">
        Enter User Name
        </FormHelperText>
        </FormControl>
        </Grid>
        </Grid>
        <Grid container spacing={2}>
        <Grid item xs={12} style={{margin:'10px 0'}}>
        <FormControl fullWidth>
        <InputLabel htmlFor="my-input">User Email</InputLabel>
        <Input id="my-input" aria-describedby="my-helper-text" type='email'  onChange={(e)=>this.setState({email: e.target.value })} />
        <FormHelperText id="my-helper-text">
        Enter User Email
        </FormHelperText>
        </FormControl>
        </Grid>
        </Grid>
        <Grid container spacing={2}>
        <Grid item xs={12} style={{margin:'10px 0'}}>
        <FormControl fullWidth>
        <InputLabel htmlFor="my-input">User Phone Number</InputLabel>
        <Input id="my-input" aria-describedby="my-helper-text" type='number'  onChange={(e)=>this.setState({mobile: e.target.value })} />
        <FormHelperText id="my-helper-text">
        Enter Phone Number
        </FormHelperText>
        </FormControl>
        </Grid>
        </Grid>
        <Grid container spacing={2}>
        <Grid item xs={12} style={{margin:'10px 0'}}>
        <FormControl fullWidth>
        <InputLabel htmlFor="my-input">User RFID Number</InputLabel>
        <Input id="my-input" aria-describedby="my-helper-text" type='text'  onChange={(e)=>this.setState({rfid_No: e.target.value })} />
        <FormHelperText id="my-helper-text">
        Enter RFID Number
        </FormHelperText>
        </FormControl>
        </Grid>
        </Grid>
        <Grid container spacing={2}>
        <Grid item xs={12} style={{margin:'10px 0'}}>  
            <FormControl fullWidth>
            <Button variant="outlined" onClick={this.addUser}>Add User</Button>
            </FormControl>
        </Grid>
        </Grid>
        </form>
        </Container>
      </>
    )
  }
}
