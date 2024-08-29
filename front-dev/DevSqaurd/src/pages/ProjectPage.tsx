import { Route, Routes } from "react-router-dom";
import ProjectMain from "../components/project/ProjectMain"
import TestPage from "./TestPage";

const ProjectPage = () => {
  return (
    <Routes>
      <Route path="/" element={<ProjectMain />} />
      <Route path="/test" element={<TestPage />} />
    </Routes>
  );
};

export default ProjectPage;