import React, { useState, useEffect } from 'react';
import Table from 'react-bootstrap/Table';
import axios from 'axios';

export default function JobList() {
  const [jobs, setJobs] = useState([]);

  const url = "http://localhost:7070/job/jobs";

  useEffect(() => {
    // Fetch the list of jobs from the API
    axios.get(url)
      .then(response => {
        setJobs(response.data);
      })
      .catch(error => {
        console.error(error);
        // Handle error
      });
  }, []);

  return (
    <Table striped bordered hover variant="dark">
      <thead>
        <tr>
          <th>Job ID</th>
          <th>Job Title</th>
          <th>Role</th>
          <th>Key Skills</th>
          {/* Add more columns as needed */}
        </tr>
      </thead>
      <tbody>
        {jobs.map(job => (
          <tr key={job.jobId}>
            <td>{job.jobId}</td>
            <td>{job.jobTitle}</td>
            <td>{job.role}</td>
            <td>{job.keySkills}</td>     
            {/* Add more columns as needed */}
          </tr>
        ))}
      </tbody>
    </Table>
  );
}
