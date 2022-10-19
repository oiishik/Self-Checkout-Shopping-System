import React, { Component } from 'react'
import Table from '@mui/material/Table';
import TableBody from '@mui/material/TableBody';
import TableCell from '@mui/material/TableCell';
import TableContainer from '@mui/material/TableContainer';
import TableHead from '@mui/material/TableHead';
import TableRow from '@mui/material/TableRow';
import Paper from '@mui/material/Paper';
import {Typography, AppBar, Card, CardActions, CardContent, CardMedia, CssBaseline, Grid, Link,Toolbar,Container,ButtonGroup,Button} from '@mui/material'

export default class UserList extends Component {
    constructor(props) {
        super(props)
        this.state = {
            users:[],
        }
    }

    componentDidMount() {
        fetch('http://localhost:8080/user/all')
            .then(res => res.json())
            .then(data => {
                this.setState({
                    users: data
                })
            }
            )
    }
  render() {
    return (
      <>
    <CssBaseline /> 
    <Typography  variant="h4" color="#34A5DD" align="center" noWrap style={{padding:'0px 5px', marginTop: '20px'}}>User List
    </Typography>
    <TableContainer component={Paper} style={{marginTop:'20px'}}>
      <Table sx={{ minWidth: 650 }} size="small" aria-label="a dense table">
        <TableHead>
          <TableRow>
            <TableCell align="center" style={{fontWeight:'bold'}}>User Name</TableCell>
            <TableCell align="center"  style={{fontWeight:'bold'}}>User Email</TableCell>
            <TableCell align="center"  style={{fontWeight:'bold'}}>User Mobile</TableCell>
            <TableCell align="center"  style={{fontWeight:'bold'}}>User RFID</TableCell>
          </TableRow>
        </TableHead>
        <TableBody>
        {this.state.users.map(users => (
            <TableRow key={users.rfid_No} sx={{ '&:last-child td, &:last-child th': { border: 0 } }}>
              <TableCell align="center">{users.name}</TableCell>
              <TableCell align="center">{users.email}</TableCell>
              <TableCell align="center">{users.mobile}</TableCell>
              <TableCell align="center">{users.rfid_No}</TableCell>
            </TableRow>
          ))}
        </TableBody>
      </Table>
    </TableContainer>
        
      </>
    )
  }
}
