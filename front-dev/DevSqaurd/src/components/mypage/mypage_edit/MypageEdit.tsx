import { useState } from "react";
import ProfileCardEdit from "./ProfileCardEdit";
import style from "../styles/mypage_main/MypageMain.module.css"

const MypageEdit = () => {
  const [profile, setProfile] = useState({
    nickname: "김태환",
    language: "Java",
    streakCount: 30,
    mannerTemperature: 15,
  });

  const handleProfileUpdate = (updatedProfile:{ nickname: string; language: string }) => {
    setProfile((prevProfile) => (
      {
        ...prevProfile, ...updatedProfile,
      }
    ))
  }
  return (
    <div className={style.container}>
      <ProfileCardEdit
        nickname={profile.nickname}
        language={profile.language}
        mannerTemperature={profile.mannerTemperature}
        update={handleProfileUpdate}
      />
      <h1>프로젝트 편집</h1>
    </div>
  );
};
export default MypageEdit;
