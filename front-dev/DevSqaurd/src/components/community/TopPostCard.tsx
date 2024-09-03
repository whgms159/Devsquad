import React, { useState, useEffect } from 'react';
import style from './styles/TopPostCard.module.css';

interface Post {
  id: number;
  title: string;
  likes: number;
  views: number;
}

export default function TopPostCard() {
  const [topPosts, setTopPosts] = useState<Post[]>([]);

  useEffect(() => {
    // 하드코딩된 조회수 상위 5개 게시물 데이터
    const fetchTopPosts = async () => {
      // 예시 데이터
      const examplePosts: Post[] = [
        { id: 1, title: '게시물 1', likes: 47, views: 1500 },
        { id: 2, title: '게시물 2', likes: 42, views: 1200 },
        { id: 3, title: '게시물 3', likes: 29, views: 1100 },
        { id: 4, title: '게시물 4', likes: 12, views: 900 },
        { id: 5, title: '게시물 5', likes: 9, views: 800 }
      ];

      setTopPosts(examplePosts);
    };

    fetchTopPosts();
  }, []);

  return (
    <div className={style.container}>
      <h3>Best Five</h3>
      <div className={style.postList}>
        <div className={`${style.postRow} ${style.header}`}>
          <div>순위</div>
          <div>제목</div>
          <div>좋아요</div>
          <div>조회수</div>
        </div>
        {topPosts.map((post, idx) => (
          <div key={post.id} className={style.postRow}>
            <div className={style.postIdx}>{idx + 1}</div>
            <div className={style.postTitle}>{post.title}</div>
            <div className={style.postLikes}>{post.likes}</div>
            <div className={style.postViews}>{post.views}</div>
          </div>
        ))}
      </div>
    </div>
  );
}
