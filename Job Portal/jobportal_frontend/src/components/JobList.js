import React, { useState, useEffect } from 'react';
import Table from 'react-bootstrap/Table';
import axios from 'axios';
import Button from 'react-bootstrap/Button';


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

  const handleJobApplication = async (jobId) => {
    if (!jobId) {
      console.log("Please select a job to apply for.");
      return;
    }
  
    try {
      const response = await axios.post(
        `http://localhost:7070/job/application/${jobId}`, // Update the URL with the job ID
       
      );
      console.log("Job application response:", response.data);
      // Handle the response or show a success message
    } catch (error) {
      console.error("Job application error:", error);
      // Handle the error
    }
  };

  return (
    <Table striped bordered hover variant="dark">
      <thead>
        <tr>
          <th>Job ID</th>
          <th>Job Title</th>
          <th>Role</th>
          <th>Key Skills</th>
        </tr>
      </thead>
      <tbody>
        {jobs.map(job => (
          <tr key={job.jobId}>
            <td>{job.jobId}</td>
            <td>{job.jobTitle}</td>
            <td>{job.role}</td>
            <td>{job.keySkills}</td>   
            <td><form action='/application/apply'><Button variant="success" type="submit" onClick={() => handleJobApplication(job.jobId)}>Apply</Button></form></td>  
            
          </tr>
        ))}
      </tbody>
    </Table>
  );
}
