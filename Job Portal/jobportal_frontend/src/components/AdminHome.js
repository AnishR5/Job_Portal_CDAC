import React, { useState, useEffect } from 'react';
import axios from 'axios';
import Table from 'react-bootstrap/Table';

export default function AdminHome() {
    const [jobProviders, setJobProviders] = useState([]);
  const [jobSeekers, setJobSeekers] = useState([]);

  useEffect(() => {
    // Fetch job providers list
    axios.get('http://localhost:7070/jobprovider/providerlist')
      .then(response => {
        setJobProviders(response.data);
      })
      .catch(error => {
        console.error('Error fetching job providers:', error);
      });

    // Fetch job seekers list
    axios.get('http://localhost:7070/jobseeker/seekerlist')
      .then(response => {
        setJobSeekers(response.data);
      })
      .catch(error => {
        console.error('Error fetching job seekers:', error);
      });
  }, []);
  return (
    <div><h1>Admin Home</h1>

    <h2>Job Providers</h2>
    <Table striped bordered hover variant="dark">
      <thead>
        <tr>
          <th>JP ID</th>
          <th>Name</th>
          <th>User Name</th>
          <th>Website</th>
        </tr>
      </thead>
      <tbody>
      {jobProviders.map(provider => (
            <tr key={provider.jpId}>
              <td>{provider.jpId}</td>
              <td>{provider.jpName}</td>
              <td>{provider.userName}</td>
              <td>{provider.webSite}</td>
            </tr>
          ))}
      </tbody>
    </Table>

    <h2>Job Seekers</h2>
    <Table striped bordered hover variant="dark">
      <thead>
        <tr>
          <th>JS ID</th>
          <th>Name</th>
          <th>User Name</th>
          <th>Email</th>
        </tr>
      </thead>
      <tbody>
      {jobSeekers.map(seeker => (
            <tr key={seeker.jsId}>
                <td>{seeker.jsId}</td>
              <td>{seeker.jsFullName}</td>
              <td>{seeker.userName}</td>
              <td>{seeker.email}</td>
              
            </tr>
          ))}
      </tbody>
    </Table>
    
    </div>
  )
}
