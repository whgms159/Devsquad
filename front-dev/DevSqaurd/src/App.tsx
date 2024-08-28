import { Route, Routes } from "react-router-dom";
import "./App.css";
import TestPage from "./pages/TestPage";
import ProjectMain from "./components/project/ProjectMain";

function App() {
  return (
    <Routes>
      <Route path="/test" element={<TestPage/>} />

      {/* 프로젝트 페이지들 */}
      <Route path="/project" element={<ProjectMain/>} />


    </Routes>
  );
}

export default App;
